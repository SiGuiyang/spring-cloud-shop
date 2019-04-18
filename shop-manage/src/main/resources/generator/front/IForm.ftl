<template>
  <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
    <el-form ref="dataForm" :model="formData" label-position="left" label-width="100px" width="50%">
<#if columns??>
  <#list columns as column>
  <#if column.changeColumnName != 'id'>
      <el-form-item label="<#if column.columnComment != ''>${column.columnComment}<#else>${column.changeColumnName}</#if>">
        <el-input v-model="form.${column.changeColumnName}" style="width: 370px;"/>
      </el-form-item>
  </#if>
  </#list>
</#if>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogFormVisible = false">取消</el-button>
      <el-button type="primary" @click="dialogStatus==='create'?handleCreateData():handleUpdateData()">确认</el-button>
    </div>
  </el-dialog>
</template>

<script>
import { modify, add } from '@/api/{changeClassName}'

export default {
  name: 'Form',
  props: {
    formData: {
      type: Object,
      default: () => ({})
    }
  },
  data() {
    return {
      dialogFormVisible: false,
      dialogPvVisible: false,
      passwordDisabled: false,
      dialogStatus: 'create',
      textMap: {
        update: '编辑',
        create: '新增'
      }
    }
  },
  methods: {
    handleCreateData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          this.formData.createUser = this.$store.state.user.username
          add(this.formData).then(() => {
            this.dialogFormVisible = false
            this.$notify({
              title: '成功',
              message: '创建成功',
              type: 'success',
              duration: 2000
            })
            this.$parent.getList()
          })
        }
      })
    },
    handleUpdateData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          const formDataData = Object.assign({}, this.formData)
          modify(formDataData).then(() => {
            this.dialogFormVisible = false
            this.$notify({
              title: '成功',
              message: '更新成功',
              type: 'success',
              duration: 2000
            })
            this.$parent.getList()
          })
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
