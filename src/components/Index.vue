<template>
  <div id="index-page">
    <el-container style="height: 500px; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu router :default-openeds="['0']">
          <el-submenu
            v-for="(item, index) in $router.options.routes"
            :key="index"
            :index="index + ''"
          >
            <template slot="title"
              ><i class="el-icon-message"></i>{{ item.name }}</template
            >
            <el-menu-item
              v-for="(item2, index2) in item.children"
              :key="index2"
              :index="item2.path"
              :class="$route.path == item2.path ? 'is-active' : ''"
              v-if="item2.show"
            >
              {{ item2.name }}
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  data() {
    const item = {
      date: "2016-05-02",
      name: "王小虎",
      address: "上海市普陀区金沙江路 1518 弄",
    };
    return {
      tableData: Array(20).fill(item),
    };
  },
  methods: {
    // getRouter: function () {
    //   var a = this.$router.options.routes;
    //   for (let i in a) {
    //     console.log(a[i].show);
    //   }
    // },
  },
  mounted() {
    // this.getRouter();
  },
};
</script>

<style scoped>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>