import request from '@/router/axios'
const uploadPath = process.env.HOST + '/upload/admin'
export { uploadPath }

export function createStorage(data) {
  return request({
    url: uploadPath,
    method: 'post',
    data
  })
}
