<template>
  <div id="blog-manage">
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column fixed prop="id" label="编号" width="100">
      </el-table-column>
      <el-table-column fixed prop="title" label="标题" width="200">
      </el-table-column>
      <el-table-column prop="text" label="内容" width="300"> </el-table-column>
      <el-table-column prop="category" label="类别" width="150">
      </el-table-column>
      <el-table-column prop="author" label="作者" width="150">
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="120">
        <template slot-scope="scope">
          <el-button @click="update(scope.row)" type="text" size="small"
            >修改</el-button
          >
          <el-button @click="del(scope.row)" type="text" size="small"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      layout="prev, pager, next"
      :page-size="limit"
      :total="totalsize"
      @current-change="changePage"
    >
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: "blog-manage",
  methods: {
    update(row) {
      // console.log(row);
      this.$router.push({
        path: "/updateblog",
        query: {
          id: row.id,
        },
      });
    },
    del: function (row) {
      const _this = this;
      this.axios
        .delete("http://localhost:8081/blogs/deleteById/" + row.id)
        .then(function (res) {
          // console.log(res)
          if (res.status == 200) {
            _this.$alert(
              "博客 '" + row.title + "' 删除成功!",
              "消息",
              {
                confirmButtonText: "确定",
                callback: (action) => {
                  // _this.$router.replace("/blogmange");
                  window.location.reload();
                },
              }
            );
          }
        });
    },
    changePage: function (currentPage) {
      //   alert(currentPage);
      const _this = this;
      this.axios
        .get("http://localhost:8081/blogs/findAll/" + currentPage + "/6")
        .then(function (res) {
          _this.tableData = res.data.content;
          _this.totalsize = res.data.totalElements;
        });
    },
  },

  data() {
    return {
      tableData: null,
      totalsize: null,
      limit: 6,
    };
  },

  created() {
    const _this = this;
    this.axios
      .get("http://localhost:8081/blogs/findAll/1/6")
      .then(function (res) {
        _this.tableData = res.data.content;
        _this.totalsize = res.data.totalElements;
      });
  },
};
</script>

<style scoped>
</style>