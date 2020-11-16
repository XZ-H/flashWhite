import BlogsManage from "./components/BlogManage.vue";
import AddBlogs from "./components/AddBlogs.vue";
import UpdateBlog from "./components/UpdateBlog.vue";
// import App from './App.vue'
import Index from "./components/Index.vue";

export default [
  {
    path: "/",
    name: "博客管理",
    redirect: "/blogmange",
    component: Index,
    // show: true,
    children: [
      {
        path: "/blogmange",
        name: "查询博客",
        component: BlogsManage,
        show: true,
      },
      {
        path: "/addblogs",
        name: "添加博客",
        component: AddBlogs,
        show: true,
      },
      {
        path: "/updateblog",
        component: UpdateBlog,
        show: false,
      },
    ],
  },
];
