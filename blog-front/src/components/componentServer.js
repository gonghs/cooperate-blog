/**
 *
 * @author maple
 * @date 2019-3-10
 */
import Fullscreen from './Fullscreen.vue'
const components = [Fullscreen]

const install = (Vue) => {
  components.forEach(component => {
    Vue.component(component.name, component)
  })
}

export default {
  install,
  Fullscreen
}
