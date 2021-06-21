export const tableOption = {
  "border": true,
  "index": true,
  "indexLabel": "序号",
  "stripe": true,
  "menuAlign": "center",
  "align": "center",
  "searchMenuSpan": 6,
  "column": [
	  {
      "type": "input",
      "label": "类目ID",
      "prop": "id",
      "search":"true"
    },	  {
      "type": "input",
      "label": "类目名",
      "prop": "title",
      "search":"true"
    },	  {
      "type": "input",
      "label": "父类目ID",
      "prop": "parentId",
      "search":"true"
    },{
      "type": "select",
      "label": "级别",
      "prop": "level",
       search:true
    } ]
}
