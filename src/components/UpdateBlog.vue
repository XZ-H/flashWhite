<template>
  <div id="update-blog">
    <el-form
      :model="ruleForm"
      :rules="rules"
      ref="ruleForm"
      label-width="100px"
      class="demo-ruleForm"
    >
      <el-form-item label="编号">
        <el-input v-model="ruleForm.id" readonly></el-input>
      </el-form-item>
      <el-form-item label="标题" prop="title">
        <el-input v-model="ruleForm.title"></el-input>
      </el-form-item>

      <el-form-item label="内容" prop="text">
        <el-input type="textarea" :rows="7" v-model="ruleForm.text"></el-input>
      </el-form-item>
      <el-form-item label="类别" prop="category">
        <el-select v-model="ruleForm.category" placeholder="请选择博客类别">
          <el-option
            v-for="(cate, index) in options"
            :label="cate"
            :value="cate"
            :key="index"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="作者" prop="author">
        <el-input v-model="ruleForm.author"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')"
          >修改</el-button
        >
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      options: [],
      ruleForm: {
        id: "",
        title: "",
        text: "",
        category: "",
        author: "",
      },
      rules: {
        title: [
          { required: true, message: "标题不能为空", trigger: "blur" },
          { min: 0, max: 30, message: "长度在30个字符以内", trigger: "blur" },
        ],
        text: [{ required: true, message: "内容不能为空", trigger: "blur" }],
        category: [
          { required: true, message: "类别不能为空", trigger: "blur" },
        ],
        author: [
          { required: true, message: "作者名不能为空", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        const _this = this;
        if (valid) {
          this.axios
            .put("http://localhost:8081/blogs/update", this.ruleForm)
            .then(function (resp) {
              //   console.log(resp);
              if (resp.data == "success") {
                _this.$alert(
                  "博客 '" + _this.ruleForm.title + "' 修改成功!",
                  "消息",
                  {
                    confirmButtonText: "确定",
                    callback: (action) => {
                      _this.$router.replace("/blogmange");
                    },
                  }
                );
              }
            });
        } else {
          //   console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },

    getSingle: function () {
      return this.axios.get(
        "http://localhost:8081/blogs/findById/" + this.$route.query.id
      );
    },

    getAll: function () {
      return this.axios.get("http://localhost:8081/blogs/findAll");
    },
  },
  created() {
    // alert(this.$route.query.id)
    const _this = this;
    // console.log(this.getSingle());
    this.axios.all([_this.getSingle(), _this.getAll()]).then(
      _this.axios.spread(function (res1, res2) {
        _this.ruleForm = res1.data;
        // console.log(_this.ruleForm.id)
        for (let i = 0; i < res2.data.length; i++) {
          _this.options.push(res2.data[i].category);
          // console.log(_this.options);
          _this.options = Array.from(new Set(_this.options));
        }
      })
    );
  },
};
</script>

<style scoped>
</style>