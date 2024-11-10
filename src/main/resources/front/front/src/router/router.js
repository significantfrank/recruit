import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import qiuzhizheList from '../pages/qiuzhizhe/list'
import qiuzhizheDetail from '../pages/qiuzhizhe/detail'
import qiuzhizheAdd from '../pages/qiuzhizhe/add'
import gongsiList from '../pages/gongsi/list'
import gongsiDetail from '../pages/gongsi/detail'
import gongsiAdd from '../pages/gongsi/add'
import gerenjianliList from '../pages/gerenjianli/list'
import gerenjianliDetail from '../pages/gerenjianli/detail'
import gerenjianliAdd from '../pages/gerenjianli/add'
import mianshishenqingList from '../pages/mianshishenqing/list'
import mianshishenqingDetail from '../pages/mianshishenqing/detail'
import mianshishenqingAdd from '../pages/mianshishenqing/add'
import zhiweileixingList from '../pages/zhiweileixing/list'
import zhiweileixingDetail from '../pages/zhiweileixing/detail'
import zhiweileixingAdd from '../pages/zhiweileixing/add'
import zhiweixinxiList from '../pages/zhiweixinxi/list'
import zhiweixinxiDetail from '../pages/zhiweixinxi/detail'
import zhiweixinxiAdd from '../pages/zhiweixinxi/add'
import jianlitoudiList from '../pages/jianlitoudi/list'
import jianlitoudiDetail from '../pages/jianlitoudi/detail'
import jianlitoudiAdd from '../pages/jianlitoudi/add'
import mianshiyaoqingList from '../pages/mianshiyaoqing/list'
import mianshiyaoqingDetail from '../pages/mianshiyaoqing/detail'
import mianshiyaoqingAdd from '../pages/mianshiyaoqing/add'
import mianshijieguoList from '../pages/mianshijieguo/list'
import mianshijieguoDetail from '../pages/mianshijieguo/detail'
import mianshijieguoAdd from '../pages/mianshijieguo/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'
import discusszhiweixinxiList from '../pages/discusszhiweixinxi/list'
import discusszhiweixinxiDetail from '../pages/discusszhiweixinxi/detail'
import discusszhiweixinxiAdd from '../pages/discusszhiweixinxi/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'qiuzhizhe',
					component: qiuzhizheList
				},
				{
					path: 'qiuzhizheDetail',
					component: qiuzhizheDetail
				},
				{
					path: 'qiuzhizheAdd',
					component: qiuzhizheAdd
				},
				{
					path: 'gongsi',
					component: gongsiList
				},
				{
					path: 'gongsiDetail',
					component: gongsiDetail
				},
				{
					path: 'gongsiAdd',
					component: gongsiAdd
				},
				{
					path: 'gerenjianli',
					component: gerenjianliList
				},
				{
					path: 'gerenjianliDetail',
					component: gerenjianliDetail
				},
				{
					path: 'gerenjianliAdd',
					component: gerenjianliAdd
				},
				{
					path: 'mianshishenqing',
					component: mianshishenqingList
				},
				{
					path: 'mianshishenqingDetail',
					component: mianshishenqingDetail
				},
				{
					path: 'mianshishenqingAdd',
					component: mianshishenqingAdd
				},
				{
					path: 'zhiweileixing',
					component: zhiweileixingList
				},
				{
					path: 'zhiweileixingDetail',
					component: zhiweileixingDetail
				},
				{
					path: 'zhiweileixingAdd',
					component: zhiweileixingAdd
				},
				{
					path: 'zhiweixinxi',
					component: zhiweixinxiList
				},
				{
					path: 'zhiweixinxiDetail',
					component: zhiweixinxiDetail
				},
				{
					path: 'zhiweixinxiAdd',
					component: zhiweixinxiAdd
				},
				{
					path: 'jianlitoudi',
					component: jianlitoudiList
				},
				{
					path: 'jianlitoudiDetail',
					component: jianlitoudiDetail
				},
				{
					path: 'jianlitoudiAdd',
					component: jianlitoudiAdd
				},
				{
					path: 'mianshiyaoqing',
					component: mianshiyaoqingList
				},
				{
					path: 'mianshiyaoqingDetail',
					component: mianshiyaoqingDetail
				},
				{
					path: 'mianshiyaoqingAdd',
					component: mianshiyaoqingAdd
				},
				{
					path: 'mianshijieguo',
					component: mianshijieguoList
				},
				{
					path: 'mianshijieguoDetail',
					component: mianshijieguoDetail
				},
				{
					path: 'mianshijieguoAdd',
					component: mianshijieguoAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
				{
					path: 'discusszhiweixinxi',
					component: discusszhiweixinxiList
				},
				{
					path: 'discusszhiweixinxiDetail',
					component: discusszhiweixinxiDetail
				},
				{
					path: 'discusszhiweixinxiAdd',
					component: discusszhiweixinxiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
