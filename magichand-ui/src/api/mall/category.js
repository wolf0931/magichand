/*
 *    Copyright (c) 2018-2025, magichand All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the magichand.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: magichand (1131960938@qq.com)
 */

import request from '@/router/axios'

export function listCategory(query) {
  return request({
    url: '/mall/category/page',
    method: 'get',
    params: query
  })
}

export function createCategory(obj) {
  return request({
    url: '/mall/category',
    method: 'post',
    data: obj
  })
}

export function getObj(id) {
  return request({
    url: '/mall/category/' + id,
    method: 'get'
  })
}

export function deleteCategory(id) {
  return request({
    url: '/mall/category/' + id,
    method: 'delete'
  })
}

export function updateCategory(obj) {
  return request({
    url: '/mall/category',
    method: 'put',
    data: obj
  })
}

export function categoryTree() {
  return request({
    url: '/mall/category/tree',
    method: 'get'
  })
}
