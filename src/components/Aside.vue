<script setup>

</script>

<template>
  <div>
        <el-menu
            style="width: 200px; min-height: calc(100vh - 50px)"
            default-active="2"
            class="el-menu-vertical-demo">
          <el-sub-menu index="1">
            <template #title>
              <el-icon><location /></el-icon>
              <span>选项1</span>
            </template>
            <el-sub-menu index="1-4">
              <template #title>选项1-1</template>
              <el-menu-item index="1-4-1">item one</el-menu-item>
            </el-sub-menu>
          </el-sub-menu>
          <el-menu-item index="2">
            <el-icon><icon-menu /></el-icon>
            <span>选项2</span>
          </el-menu-item>
          <el-menu-item index="4">
            <el-icon><setting /></el-icon>
            <span>选项3</span>
          </el-menu-item>
        </el-menu>
  </div>
</template>

<style scoped>

</style>