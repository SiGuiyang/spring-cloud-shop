//package quick.pager.shop.manage.service.system.impl;
//
//import SysUserResponse;
//import quick.pager.shop.service.IService;
//
///**
// * 用户信息| 包含权限
// *
// * @author siguiyang
// * @version 3.0
// */
//
//public interface SysUserInfoService extends IService<SysUserResponse> {
//
////    @Autowired
////    private SysUserMapper sysUserMapper;
////    @Autowired
////    private MenuMapper menuMapper;
////
////    @Override
////    public Response<SysUserResponse> doService(BaseDTO dto) {
////
////        LoginDTO loginDTO = (LoginDTO) dto;
////
////        Response<SysUserResponse> response = new Response<>();
////        SysUser queryUser = new SysUser();
////        queryUser.setPhone(loginDTO.getUsername());
////        queryUser.setDeleteStatus(Boolean.FALSE);
////        SysUser sysUser = sysUserMapper.selectOne(new QueryWrapper<>(queryUser));
////
////        if (Objects.isNull(sysUser)) {
////            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.USER_PHONE_NOT_EXISTS);
////        }
////
////        SysUserResponse sysUserResponse = new SysUserResponse();
////
////        // 登陆用户所有角色
////        Collection<? extends GrantedAuthority> authorities = PrincipalUtils.getPrincipal().getAuthorities();
////
////        List<String> permissions = authorities.stream().map(GrantedAuthority::getAuthority).distinct().collect(Collectors.toList());
////
////        // 所有访问菜单的路由
////        List<Menu> menus = menuMapper.selectMenuBySysUserId(sysUser.getId());
////        // 父级菜单
////        List<MenuResponse> topMenu = Optional.ofNullable(menus).orElse(Collections.emptyList()).stream()
////                .filter(menu -> Objects.isNull(menu.getParentId()))
////                .map(this::conv)
////                .collect(Collectors.toList());
////        // 这种写法是查出所有的菜单，移除顶级菜单，剩余的菜单就不是顶级菜单也就是parentId 都是不为null
////        Map<Long, List<MenuResponse>> childrenMap = Optional.ofNullable(menus).orElse(Collections.emptyList()).stream()
////                .filter(item -> Objects.nonNull(item.getParentId()))
////                .map(this::conv)
////                .collect(Collectors.groupingBy(MenuResponse::getParentId, Collectors.toList()));
////        // 整合成父子结构
////        recursivePermission(topMenu, childrenMap);
////
////        sysUserResponse.setPhone(sysUser.getPhone());
////        sysUserResponse.setUsername(sysUser.getUsername());
////        sysUserResponse.setRouters(topMenu);
////        sysUserResponse.setPermissions(permissions);
////
////        response.setData(sysUserResponse);
////
////        return response;
////    }
////
////    /**
////     * 获取访问菜单
////     *
////     * @param menus       TOP菜单
////     * @param childrenMap 孩子节点菜单
////     */
////    private void recursivePermission(List<MenuResponse> menus, Map<Long, List<MenuResponse>> childrenMap) {
////        menus.forEach(k -> {
////            MenuResponse.Meta meta = new MenuResponse.Meta(k.getName(), k.getIcon(), k.getHidden(), Lists.newArrayList(k.getPermission()));
////            k.setMeta(meta);
////            List<MenuResponse> menuList = Optional.ofNullable(childrenMap.get(k.getId())).orElse(Collections.emptyList()).stream()
////                    .filter(item -> 1 == item.getMenuType())
////                    .collect(Collectors.toList());
////            recursivePermission(menuList, childrenMap);
////            k.setChildren(menuList);
////        });
////    }
////
////    private MenuResponse conv(Menu menu) {
////        MenuResponse resp = new MenuResponse();
////        BeanCopier.create(menu, resp).copy();
////        resp.setLabel(menu.getName());
////        if (Objects.isNull(menu.getParentId())) {
////            resp.setComponent("Layout");
////        }
////        return resp;
////    }
//}
