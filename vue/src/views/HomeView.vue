<template>
  <div style="padding: 10px">

<!--    功能区-->
    <div style="margin: 10px 0">
      <el-button type="primary" @click="add">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>

<!--    搜索区-->
    <div style="margin: 10px 0">
      <el-input v-model="keyWord" placeholder="输入关键字搜索" style="width: 20%" clearable/>
      <el-button type="primary" style="margin-left: 5px" @click="load">搜索</el-button>
    </div>

    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column prop="userId" label="编号" sortable />
      <el-table-column prop="userName" label="姓名"/>
      <el-table-column prop="gender" label="性别" />
      <el-table-column prop="age" label="年龄" />
      <el-table-column prop="department" label="部门" />
      <el-table-column prop="joinDate" label="入职时间" />
      <el-table-column prop="email" label="邮箱" />
      <el-table-column prop="phoneNumber" label="电话" />
      <el-table-column fixed="right" label="操作" width="140px">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm title="确认删除？">
            <template #reference>
              <el-button size="small" type="danger" @click="handleDelete(scope.row)">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px 0" >
      <el-pagination
          :current-page="currentPage"
          :page-size="pageSize"
          :page-sizes="[5, 10, 20]"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange">
      </el-pagination>
      <el-dialog v-model="dialogVisible" title="提示" width="500">
        <el-form :model="form" label-width="120px">
          <el-form-item label="姓名">
            <el-input v-model="form.username" style="width: 80%"/>
          </el-form-item>
        </el-form>
        <el-form :model="form" label-width="120px">
          <el-form-item label="性别">
            <el-radio v-model="form.gender" label="男">男</el-radio>
            <el-radio v-model="form.gender" label="女">女</el-radio>
          </el-form-item>
        </el-form>
        <el-form :model="form" label-width="120px">
          <el-form-item label="年龄">
            <el-input v-model="form.age" style="width: 80%"/>
          </el-form-item>
        </el-form>
<!--        <el-form :model="form" label-width="120px">-->
<!--          <el-form-item label="部门">-->
<!--            <el-input v-model="form.department" style="width: 80%"/>-->
<!--          </el-form-item>-->
<!--        </el-form>-->
        <el-form :model="form" label-width="120px">
          <el-form-item label="入职时间">
            <el-input v-model="form.joindate" style="width: 80%"/>
          </el-form-item>
        </el-form>
        <el-form :model="form" label-width="120px">
          <el-form-item label="邮箱">
            <el-input v-model="form.email" style="width: 80%"/>
          </el-form-item>
        </el-form>
        <el-form :model="form" label-width="120px">
          <el-form-item label="电话">
            <el-input v-model="form.phonenumber" style="width: 80%"/>
          </el-form-item>
        </el-form>
        <template #footer>
          <div class="dialog-footer">
            <el-button @click="dialogVisible = false">取消</el-button>
            <el-button type="primary" @click="save">
              确定
            </el-button>
          </div>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>



import request from "../../utils/request";

export default {
  name: 'HomeView',
  components: {

  },
  data(){
    return {
      form: {},
      dialogVisible: false,
      keyWord: '',
      currentPage: 1,
      pageSize: 10,
      total: 0,
      tableData: []
    }
  },
  // 加载时调用load方法
  created() {
    // this.load()
  },
  methods: {
    load(){
      request.get("/user", {
        //get请求
        params:{
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          keyWord: this.keyWord
        },
      }).then(res => {
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    add(){
      //展示弹出页面
      this.dialogVisible = true
      this.form = {}
    },
    save(){
      request.post("/user", this.form).then(res =>{
        console.log(res)
      })
    },
    handleEdit(row){
      // 深拷贝
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true
    },
    handleDelete(){

    },
    handleSizeChange(){

    },
    handleCurrentChange(){

    }
  }
}
</script>