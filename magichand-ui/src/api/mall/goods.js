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

export function listGoods(query) {
  return request({
    url: '/mall/goods/page',
    method: 'get',
    params: query
  })
}

export function createGoods(obj) {
  return request({
    url: '/mall/goods',
    method: 'post',
    data: obj
  })
}

export function getGood(id) {
  return request({
    url: '/mall/goods/' + id,
    method: 'get'
  })
}

export function deleteGood(id) {
  return request({
    url: '/mall/goods/' + id,
    method: 'delete'
  })
}

export function updateGood(obj) {
  return request({
    url: '/mall/goods',
    method: 'put',
    data: obj
  })
}
