<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input v-model="listQuery.id" clearable class="filter-item" style="width: 200px;" placeholder="请输入类目ID"/>
      <el-input v-model="listQuery.title" clearable class="filter-item" style="width: 200px;" placeholder="请输入类目名称"/>
      <el-select v-model="listQuery.level" clearable style="width: 200px" class="filter-item" placeholder="请选择类目级别">
        <el-option v-for="(item,index) in categoryLevelMap" :key="index" :label="item.text" :value="item.value"/>
      </el-select>
      <el-cascader
        :options="options"
        :props="{ checkStrictly: true }"
        v-model="queryOptions"
        style="width: 200px"
        class="filter-item"
        placeholder="请选择父类目"
        filterable
        clearable
        @change="handleQuery"
      />
      <el-button
        class="filter-item"
        type="primary"
        icon="el-icon-search"
        @click="handleFilter"
      >查找
      </el-button>
      <el-button
        class="filter-item"
        type="primary"
        icon="el-icon-edit"
        @click="handleCreate"
      >添加
      </el-button>
    </div>

    <!-- 查询结果 -->
    <el-table
      v-loading="listLoading"
      :data="list"
      size="small"
      element-loading-text="正在查询中。。。"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" label="类目ID" prop="value"/>

      <el-table-column align="center" label="类目名" prop="label">
        <template slot-scope="scope">
          <el-tag>{{ scope.row.label }}</el-tag>
        </template>
      </el-table-column>

      <el-table-column align="center" label="全类目名" prop="fullName">
        <template slot-scope="scope">
          <el-tag>{{ scope.row.fullName }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" label="父类目ID" prop="parent"/>

      <el-table-column align="center" label="级别" prop="level">
        <template slot-scope="scope">
          <el-tag>{{ scope.row.level | categoryLevelFilter }}</el-tag>
        </template>
      </el-table-column>

      <el-table-column align="center" label="操作" width="200" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            type="primary"
            size="mini"
            @click="handleUpdate(scope.row)"
          >编辑
          </el-button>
          <el-button
            type="danger"
            size="mini"
            @click="handleDelete(scope.row)"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="listQuery.current"
      :limit.sync="listQuery.size"
      @pagination="getList"
    />

    <!-- 添加或修改对话框 -->
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form
        ref="dataForm"
        :rules="rules"
        :model="dataForm"
        status-icon
        label-position="left"
        label-width="100px"
        style="width: 400px; margin-left: 50px"
      >
        <el-form-item label="类目ID" prop="id" hidden>
          <el-input v-model="dataForm.id" />
        </el-form-item>
        <el-form-item label="类目名称" prop="title">
          <el-input v-model="dataForm.title" @input="tlog" />
        </el-form-item>
        <el-form-item label="类目图片" prop="picUrl">
          <el-upload
            :action="uploadPath"
            :show-file-list="false"
            :on-success="pirUploadSuccessHandle"
            :before-upload="onBeforeUpload"
            class="avatar-uploader"
            accept=".jpg, .jpeg, .png, .gif"
          >
            <img v-if="dataForm.picUrl" ref="adImg" :src="dataForm.picUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon" />
          </el-upload>
        </el-form-item>

        <el-form-item label="父类目">
          <el-cascader
            :options="options"
            :props="{checkStrictly: true}"
            v-model="dialogOptions"
            placeholder="选择父类目，默认一级类目"
            filterable
            clearable
            @change="handleLink"
          />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button v-if="dialogStatus=='create'" type="primary" @click="createData">确定</el-button>
        <el-button v-else type="primary" @click="updateData">确定</el-button>
      </div>
    </el-dialog>

    <!-- 添加或修改对话框 -->
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form
        ref="dataForm"
        :rules="rules"
        :model="dataForm"
        status-icon
        label-position="left"
        label-width="100px"
        style="width: 400px; margin-left:50px;"
      >
        <el-form-item label="类目ID" prop="id" hidden>
          <el-input v-model="dataForm.id" />
        </el-form-item>
        <el-form-item label="类目名称" prop="title">
          <el-input v-model="dataForm.title" @input="tlog" />
        </el-form-item>
        <el-form-item label="类目图片" prop="picUrl">
          <el-upload
            :action="uploadPath"
            :show-file-list="false"
            :on-success="pirUploadSuccessHandle"
            :before-upload="onBeforeUpload"
            class="avatar-uploader"
            accept=".jpg, .jpeg, .png, .gif"
          >
            <img v-if="dataForm.picUrl" ref="adImg" :src="dataForm.picUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon" />
          </el-upload>
        </el-form-item>

        <el-form-item label="父类目">
          <el-cascader
            :options="options"
            :props="{ checkStrictly: true }"
            v-model="dialogOptions"
            placeholder="选择父类目，默认一级类目"
            filterable
            clearable
            @change="handleLink"
          />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button v-if="dialogStatus=='create'" type="primary" @click="createData">确定</el-button>
        <el-button v-else type="primary" @click="updateData">确定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import {categoryTree, listCategory, createCategory, deleteCategory, updateCategory} from '@/api/mall/category'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination
import {clearTreeEmptyChildren} from '@/util/index'
import { uploadPath } from '@/api/storage'

const categoryLevelMap = [{text: '一级类目', value: 0}, {text: '二级类目', value: 1}, {text: '三级类目', value: 2}]
export default {
  name: 'Category',
  components: {Pagination},
  filters: {
    categoryLevelFilter(code) {
      if (code >= 0 && code < 3) {
        return categoryLevelMap[code].text
      }
      return '错误级别'
    }
  },
  data() {
    return {
      options: [],
      categoryLevelMap,
      uploadPath,
      queryOptions: undefined,
      listLoading: true,
      total: 0,
      listQuery: {
        current: 1,
        size: 10,
        id: undefined,
        title: undefined,
        level: undefined,
        parentId: undefined
      },
      list: [],
      dialogOptions: undefined,
      dataForm: {
        id: undefined,
        title: undefined,
        level: undefined,
        parentId: undefined
      },
      dialogFormVisible: false,
      dialogStatus: '',
      textMap: {
        update: '编辑',
        create: '创建'
      },
      currentParent: undefined,
      current: undefined,
      rules: {
        title: [{required: true, message: '类目名不能为空', trigger: 'blur'}]
      },
    }
  },
  created() {
    this.getList()
    this.refreshOptions()
  },
  methods: {
    tlog(e) {
      console.log(e)
    },
    // 删除类目
    getList() {
      this.listLoading = true
      listCategory(this.listQuery).then(response => {
        this.list = response.data.data.orders
        this.total = response.data.data.total
        this.listLoading = false;
      }).catch(() => {
        this.list = []
        this.total = 0
        this.listLoading = false
      })
    },
    handleQuery(e) {
      if (e === null || e === undefined) {
        return false
      }
      this.refreshOptions();
      const tag = e[e.length - 1]
      this.listQuery.parentId = tag
    },
    // 刷新类目选择节点
    refreshOptions() {
      categoryTree().then(response => {
        this.options = clearTreeEmptyChildren(response.data.data)
      })
    },
    pirUploadSuccessHandle(e) {
      this.dataForm.picUrl = e.url
      this.dialogFormVisible = false
      this.dialogFormVisible = true
    },
    onBeforeUpload(file) {
      const isIMAGE = file.type === 'image/jpeg' || 'image/gif' || 'image/png' || 'image/jpg'
      const isLt1M = file.size / 1024 / 1024 < 1
      if (!isIMAGE) {
        this.$message.error('上传文件只能是图片格式!')
      }
      if (!isLt1M) {
        this.$message.error('上传文件大小不能超过 1MB!')
      }
      return isIMAGE && isLt1M
    },
    handleLink(e){
      console.log(e)
      if (e === null || e === undefined){
        return false
      }
      if (e.length === 0) {
        this.dataForm.parentId = 0
        return true
      }
      const tag = e[e.length -1]
      if (this.dialogStatus === 'update') {
        if (this.dataForm.id === tag) {
          this.$notify.error({
            title: '失败',
            message: '请不要选择本节点作为父节点'
          })
        }
      }
      this.dataForm.parentId = tag
    },
    createData(){
      this.$refs['dataForm'].validate(valid => {
        console.info(this.dataForm)
        createCategory(this.dataForm)
          .then(response => {
            this.resetQuery()
            this.listQuery.title = this.dataForm.title
            this.getList()
            this.dialogFormVisible = false
            if (response.data.code === 0){
              this.$notify.success({
                title: '成功',
                message: '创建成功'
              })
            }else {
              this.$notify.error({
                title: '失败',
                message: response.data.msg
              })
            }
            this.refreshOptions()
          })
          .catch(response => {
            debugger
            this.$notify.error({
              title: '失败',
              message: response.message
            })
          })
      })
    },
    updateData() {
      this.$refs['dataForm'].validate(valid => {
        if (valid){
          updateCategory(this.dataForm).then(response => {
            this.getList()
            this.dialogFormVisible = false
            if(response.data.code === 0){
              this.$notify.success({
                title: '成功',
                message: '更新成功'
              })
            }else {
              this.$notify.error({
                title: '失败',
                message: response.data.msg
              })
            }
            this.refreshOptions()
          }).catch(response => {
            this.$notify.error({
              title: '失败',
              message: response.data.msg
            })
          })
        }
        }
      )
    },
    handleCreate() {
      this.resetForm()
      this.dialogStatus = 'create'
      this.dialogOptions = undefined
      this.queryOptions = undefined
      this.resetQuery()
      this.refreshOptions()
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    resetQuery() {
      this.listQuery = {
        current: 1,
        size: 10,
        id: undefined,
        title: undefined,
        level: undefined,
        parentId: undefined
      }
    },
    handleFilter() {
      this.listQuery.current = 1
      if (this.listQuery.id != null && isNaN(Number(this.listQuery.id))) {
        this.$notify.error({
          title: '失败',
          message: '请输入整数'
        })
        return false
      }
      this.getList()
    },
    handleUpdate(row) {
      this.dataForm = Object.assign({},{
        id: row.value,
        title: row.label,
        parentId: row.parentId,
        picUrl: row.picUrl,
        iconUrl: row.iconUrl
      })
      this.dialogOptions = row.parent
      this.refreshOptions()
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    handleDelete(row) {
      this.$confirm('此操作将永久删除该类目--' + row.label + '--, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type:'warning'
      }).then(() => {
        deleteCategory(row.value)
          .then(response =>{
            debugger
            if (response.data.data.code === 0){
              this.$notify.success({
                title: '成功',
                message: '删除成功'
              })
              const index = this.list.indexOf(row)
              this.list.splice(index, 1)
              this.refreshOptions()
            }else {
              this.$notify.error({
                title: '失败',
                message: response.data.data.msg
              })
            }
        }).catch(response => {
          this.$notify.error({
            title: '失败',
            message: response.data.msg
          })
        })
      }).catch(() => {
        return false
      })
    },
    resetForm() {
      this.dataForm = {
        id: undefined,
        title: undefined,
        level: undefined,
        fullName: undefined,
        parentId: 0,
        iconUrl: undefined,
        picUrl: undefined,
        gmt_update: new Date()
    }
    },
  }
}
</script>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #20a0ff;
}

</style>
