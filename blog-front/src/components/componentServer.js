/**
 *
 * @author maple
 * @date 2019-3-10
 */
import Fullscreen from './bg/Fullscreen.vue'
import Head from './Head.vue'
import Background from './bg/Background.vue'
const components = [Fullscreen, Head, Background]

const install = (Vue) => {
  components.forEach(component => {
    Vue.component(component.name, component)
  })
}

export default {
  install,
  Fullscreen,
  Head,
  Background
}
