<template>
  <el-tree :data="menus" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
</template>

<script>
export default {
  name: 'category',
  data() {
    return {
      menus: [],
      defaultProps: {
        children: 'children',
        label: 'name'
      }
    }
  },
  created(){
      this.getMenus();
  },
  methods: {
    handleNodeClick(data) {
      console.log(data);
    },
    getMenus(){
      this.$http({
        url: this.$http.adornUrl('/product/category/list/tree'),
        method: 'get'
      }).then(({data})=>{
        this.menus = data.data
      })
    },

  }
}
</script>

<style>

</style>