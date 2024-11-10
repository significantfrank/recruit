import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import discusszhiweixinxi from '@/views/modules/discusszhiweixinxi/list'
    import news from '@/views/modules/news/list'
    import aboutus from '@/views/modules/aboutus/list'
    import gongsi from '@/views/modules/gongsi/list'
    import forum from '@/views/modules/forum/list'
    import zhiweixinxi from '@/views/modules/zhiweixinxi/list'
    import jianlitoudi from '@/views/modules/jianlitoudi/list'
    import gerenjianli from '@/views/modules/gerenjianli/list'
    import systemintro from '@/views/modules/systemintro/list'
    import mianshishenqing from '@/views/modules/mianshishenqing/list'
    import zhiweileixing from '@/views/modules/zhiweileixing/list'
    import qiuzhizhe from '@/views/modules/qiuzhizhe/list'
    import mianshijieguo from '@/views/modules/mianshijieguo/list'
    import mianshiyaoqing from '@/views/modules/mianshiyaoqing/list'
    import config from '@/views/modules/config/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/discusszhiweixinxi',
        name: '职位信息评论',
        component: discusszhiweixinxi
      }
      ,{
	path: '/news',
        name: '公告信息',
        component: news
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/gongsi',
        name: '公司',
        component: gongsi
      }
      ,{
	path: '/forum',
        name: '论坛交流',
        component: forum
      }
      ,{
	path: '/zhiweixinxi',
        name: '职位信息',
        component: zhiweixinxi
      }
      ,{
	path: '/jianlitoudi',
        name: '简历投递',
        component: jianlitoudi
      }
      ,{
	path: '/gerenjianli',
        name: '个人简历',
        component: gerenjianli
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/mianshishenqing',
        name: '面试申请',
        component: mianshishenqing
      }
      ,{
	path: '/zhiweileixing',
        name: '职位类型',
        component: zhiweileixing
      }
      ,{
	path: '/qiuzhizhe',
        name: '求职者',
        component: qiuzhizhe
      }
      ,{
	path: '/mianshijieguo',
        name: '面试结果',
        component: mianshijieguo
      }
      ,{
	path: '/mianshiyaoqing',
        name: '面试邀请',
        component: mianshiyaoqing
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/newstype',
        name: '公告信息分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
