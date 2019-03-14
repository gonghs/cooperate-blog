package com.server.kt.common.entity

import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 * 基础数据库字段实体
 *
 * @author maple
 * @version 1.0
 * @since 2019-03-14 20:08
 */
@MappedSuperclass
open class BaseEntity{
    @Id
    @GeneratedValue
    var id:Long = 0
    /**
     * 创建时间
     */
    var createTime:Date = Date()
    /**
     * 创建人
     */
    var createUserId:Long = 0
    /**
     * 修改时间
     */
    var modifyTime:Date = Date()
    /**
     * 修改人
     */
    var modifyUserId:Long = 0
}