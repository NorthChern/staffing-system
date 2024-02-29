<template>
  <div style="padding: 10px">

<!--    功能区-->
    <div style="margin: 10px 0">
      <el-button type="primary">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>

<!--    搜索区-->
    <div style="margin: 10px 0">
      <el-input v-model="search" placeholder="输入关键字搜索" style="width: 20%"/>
      <el-button type="primary" style="margin-left: 5px">搜索</el-button>
    </div>

    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column prop="date" label="日期" sortable />
      <el-table-column prop="name" label="姓名"/>
      <el-table-column prop="address" label="地址" />
      <el-table-column fixed="right" label="操作" width="140px">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-popconfirm title="确认删除？">
            <template #reference>
              <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px 0" >
      <el-pagination
          :current-page="currentPage"
          :page-size="10"
          :page-sizes="[5, 10, 20]"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange">
      </el-pagination>
    </div>
  </div>
</template>

<script>


export default {
  name: 'HomeView',
  components: {

  },
  data(){
    return {
      search: '',
      currentPage: 1,
      total: 10,
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1517 弄'
      }]
    }
  },
  methods: {
    handleEdit(){

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
