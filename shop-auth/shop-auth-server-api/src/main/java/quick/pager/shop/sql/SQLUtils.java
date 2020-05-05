package quick.pager.shop.sql;

public class SQLUtils {

    /**
     * client 字段更新
     */
    public static final String CLIENT_FIELDS_FOR_UPDATE = "resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove, create_user,update_user, create_time, "
            + "update_time, delete_status";

    /**
     * client 字段更新
     */
    public static final String FIELDS_FOR_UPDATE = "client_name,resource_ids = ?, scope = ?, authorized_grant_types = ?, "
            + "web_server_redirect_uri = ?, authorities = ?, access_token_validity = ?, "
            + "refresh_token_validity = ?, additional_information = ?, autoapprove = ?, "
            + "update_user = ?, update_time = ?, delete_status = ?";


    /**
     * client 所有字段 sql
     */
    public static final String CLIENT_FIELDS = "client_secret, " + CLIENT_FIELDS_FOR_UPDATE;

    /**
     * 基础查询字段 sql
     */
    public static final String BASE_FIND_STATEMENT = "select client_id, " + CLIENT_FIELDS
            + " from oauth_client_details";
    /**
     * 默认查询字段sql
     */
    public static final String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by update_time";

    /**
     * 默认查询分页sql
     */
    public static final String DEFAULT_FIND_STATEMENT_LIMIT = DEFAULT_FIND_STATEMENT + " limit ?,?";
    /**
     * 根据client_id sql查询
     */
    public static final String DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";

    /**
     * 根据client_id sql 分页查询
     */
    public static final String DEFAULT_SELECT_STATEMENT_LIMIT = DEFAULT_SELECT_STATEMENT + " limit ?,?";
    /**
     * 默认插入sql
     */
    public static final String DEFAULT_INSERT_STATEMENT = "insert into oauth_client_details (" + CLIENT_FIELDS
            + ", client_id, client_name) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    /**
     * 默认更新字段sql
     */
    public static final String DEFAULT_UPDATE_STATEMENT = "update oauth_client_details set " + FIELDS_FOR_UPDATE + " where client_id = ?";
    /**
     * 默认根据client_id 更新client_secret
     */
    public static final String DEFAULT_UPDATE_SECRET_STATEMENT = "update oauth_client_details "
            + "set client_secret = ? where client_id = ?";
    /**
     * 根据client_id 删除
     */
    public static final String DEFAULT_DELETE_STATEMENT = "delete from oauth_client_details where client_id = ?";

}
