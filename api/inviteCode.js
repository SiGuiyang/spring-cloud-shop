import service from '@/utils/request'

// 获取table data
export function fetchList(data) {
  return service({
    url: '/admin/inviteCode/list',
    method: 'post',
    data
  })
}
// 新增
export function add(data) {
  return service({
    url: 'admin/inviteCode',
    method: 'post',
    data
  })
}

// 修改
export function modify(data) {
  return service({
    url: 'admin/inviteCode',
    method: 'put',
    data
  })
}

// 删除
export function del(id) {
  return service({
    url: 'admin/inviteCode/' + id,
    method: 'delete'
  })
}
