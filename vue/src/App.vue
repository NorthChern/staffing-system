<template>
  <div>
<!--头部-->
    <Header/>
<!--主体-->
    <div style="display: flex">
<!--      侧边栏-->
      <Aside/>
<!--      内容-->
      <router-view style="flex: 1"/>
    </div>
  </div>

</template>

<style>

</style>

<script>
import Header from "@/components/Header.vue";
import Aside from "@/components/Aside.vue";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Layout",
  components: {
    Aside,
    Header
  }
}

const debounce = (fn, delay) => {
  let timer = null;
  return function () {
    let context = this;
    let args = arguments;
    clearTimeout(timer);
    timer = setTimeout(function () {
      fn.apply(context, args);
    }, delay);
  };
};
// 解决ERROR ResizeObserver loop completed with undelivered notifications.
const _ResizeObserver = window.ResizeObserver;
window.ResizeObserver = class ResizeObserver extends _ResizeObserver {
  constructor(callback) {
    callback = debounce(callback, 16);
    super(callback);
  }
};
</script>
