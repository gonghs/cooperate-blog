<template>
    <div class="head-tool" @click="targetFullscreen()"><i class="el-icon-info"></i><span v-text="!fullscreen?'全屏显示':'退出全屏'"></span></div>
</template>

<script>
export default {
  name: 'Fullscreen',
  data () {
    return {
      fullscreen: false
    }
  },
  methods: {
    targetFullscreen: function () {
      let element = document.documentElement
      if (this.fullscreen) {
        if (document.exitFullscreen) {
          document.exitFullscreen()
        } else if (document.webkitCancelFullScreen) {
          document.webkitCancelFullScreen()
        } else if (document.mozCancelFullScreen) {
          document.mozCancelFullScreen()
        } else if (document.msExitFullscreen) {
          document.msExitFullscreen()
        }
      } else {
        if (element.requestFullscreen) {
          element.requestFullscreen()
        } else if (element.webkitRequestFullScreen) {
          element.webkitRequestFullScreen()
        } else if (element.mozRequestFullScreen) {
          element.mozRequestFullScreen()
        } else if (element.msRequestFullscreen) {
          // IE11
          element.msRequestFullscreen()
        }
      }
      this.fullscreen = !this.fullscreen
    }
  }
}
</script>

<style scoped>
  .head-tool{
    float:left;
    font-size: 30px;
    cursor: pointer;
    min-width: 150px;
    position: absolute;
    top: 10px;
    left: 10px;
  }
  @media screen and (max-width: 630px) {
    .head-tool {display: none}
  }
</style>
