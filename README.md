---
title: szgd v1.0.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.4"

---

# szgd

> v1.0.0

# Default

## GET 模糊查询

GET /:14308/api/file/fuzzySearch/{context}/{pageNum}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|context|path|string|true|none|
|pageNum|path|string|true|none|
|token|header|string|false|none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "message": "成功",
  "data": {
    "total": 6,
    "list": [
      {
        "fileId": 1499337118561435600,
        "userId": 1499291676721135600,
        "fileName": "default_avatar.jfif",
        "fileType": null,
        "fileSize": 1719,
        "filePath": "F:\\szgd\\storage\\1499291676721135617",
        "fileMD5": "6"
      },
      {
        "fileId": 1499338896753401900,
        "userId": 1499291676721135600,
        "fileName": "default_avatar.jfif",
        "fileType": null,
        "fileSize": 1719,
        "filePath": "F:\\szgd\\storage\\1499291676721135617\\default_avatar.jfif",
        "fileMD5": "7"
      },
      {
        "fileId": 1499339090458943500,
        "userId": 1499291676721135600,
        "fileName": "default_avatar.jfif",
        "fileType": null,
        "fileSize": 1719,
        "filePath": "F:\\szgd\\storage\\1499291676721135617\\default_avatar.jfif",
        "fileMD5": "8"
      },
      {
        "fileId": 1499344575983530000,
        "userId": 1499291676721135600,
        "fileName": "default_avatar.jfif",
        "fileType": null,
        "fileSize": 1719,
        "filePath": "F:\\szgd\\storage\\1499291676721135617\\default_avatar.jfif",
        "fileMD5": "9"
      },
      {
        "fileId": 1499346687115235300,
        "userId": 1499291676721135600,
        "fileName": "default_avatar.jfif",
        "fileType": null,
        "fileSize": 1719,
        "filePath": "F:\\szgd\\storage\\1499291676721135617\\9ac349bd82550ddc7dbfdc0bc3a3c172jfif",
        "fileMD5": "10"
      },
      {
        "fileId": 1499347023196426200,
        "userId": 1499291676721135600,
        "fileName": "default_avatar.jfif",
        "fileType": null,
        "fileSize": 1719,
        "filePath": "F:\\szgd\\storage\\1499291676721135617\\9ac349bd82550ddc7dbfdc0bc3a3c172.jfif",
        "fileMD5": "9ac349bd82550ddc7dbfdc0bc3a3c172"
      }
    ],
    "pageNum": 1,
    "pageSize": 10,
    "size": 6,
    "startRow": 1,
    "endRow": 6,
    "pages": 1,
    "prePage": 0,
    "nextPage": 0,
    "isFirstPage": true,
    "isLastPage": true,
    "hasPreviousPage": false,
    "hasNextPage": false,
    "navigatePages": 8,
    "navigatepageNums": [
      1
    ],
    "navigateFirstPage": 1,
    "navigateLastPage": 1
  },
  "ok": true
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 上传文件

POST /:14308/api/file/uploadFile

> Body 请求参数

```yaml
file: file://D:\Apifox\LICENSE.electron.txt

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|token|header|string|false|none|
|body|body|object|false|none|
|» file|body|string(binary)|true|none|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## GET 查询文件列表

GET /:14308/api/file/getList/{pageNum}

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|pageNum|path|string|true|none|
|token|header|string|true|none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "message": "成功",
  "data": {
    "total": 12,
    "list": [
      {
        "fileId": 1,
        "userId": 1499291676721135600,
        "fileName": "12323",
        "fileType": null,
        "fileSize": 11,
        "filePath": "eee",
        "fileMD5": "1"
      },
      {
        "fileId": 2,
        "userId": 1499291676721135600,
        "fileName": "4142",
        "fileType": null,
        "fileSize": 323,
        "filePath": "rrr",
        "fileMD5": "2"
      },
      {
        "fileId": 3,
        "userId": 1499291676721135600,
        "fileName": "14213",
        "fileType": null,
        "fileSize": 553,
        "filePath": "rfe",
        "fileMD5": "3"
      },
      {
        "fileId": 4,
        "userId": 1499291676721135600,
        "fileName": "tfwer",
        "fileType": null,
        "fileSize": 13123,
        "filePath": "ferew",
        "fileMD5": "4"
      },
      {
        "fileId": 5,
        "userId": 1499291676721135600,
        "fileName": "r32r",
        "fileType": null,
        "fileSize": 12341,
        "filePath": "421",
        "fileMD5": "5"
      },
      {
        "fileId": 1499337118561435600,
        "userId": 1499291676721135600,
        "fileName": "default_avatar.jfif",
        "fileType": null,
        "fileSize": 1719,
        "filePath": "F:\\szgd\\storage\\1499291676721135617",
        "fileMD5": "6"
      },
      {
        "fileId": 1499338896753401900,
        "userId": 1499291676721135600,
        "fileName": "default_avatar.jfif",
        "fileType": null,
        "fileSize": 1719,
        "filePath": "F:\\szgd\\storage\\1499291676721135617\\default_avatar.jfif",
        "fileMD5": "7"
      },
      {
        "fileId": 1499339090458943500,
        "userId": 1499291676721135600,
        "fileName": "default_avatar.jfif",
        "fileType": null,
        "fileSize": 1719,
        "filePath": "F:\\szgd\\storage\\1499291676721135617\\default_avatar.jfif",
        "fileMD5": "8"
      },
      {
        "fileId": 1499344575983530000,
        "userId": 1499291676721135600,
        "fileName": "default_avatar.jfif",
        "fileType": null,
        "fileSize": 1719,
        "filePath": "F:\\szgd\\storage\\1499291676721135617\\default_avatar.jfif",
        "fileMD5": "9"
      },
      {
        "fileId": 1499346687115235300,
        "userId": 1499291676721135600,
        "fileName": "default_avatar.jfif",
        "fileType": null,
        "fileSize": 1719,
        "filePath": "F:\\szgd\\storage\\1499291676721135617\\9ac349bd82550ddc7dbfdc0bc3a3c172jfif",
        "fileMD5": "10"
      }
    ],
    "pageNum": 1,
    "pageSize": 10,
    "size": 10,
    "startRow": 1,
    "endRow": 10,
    "pages": 2,
    "prePage": 0,
    "nextPage": 2,
    "isFirstPage": true,
    "isLastPage": false,
    "hasPreviousPage": false,
    "hasNextPage": true,
    "navigatePages": 8,
    "navigatepageNums": [
      1,
      2
    ],
    "navigateFirstPage": 1,
    "navigateLastPage": 2
  },
  "ok": true
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 登录

POST /:14308/api/user/login

> Body 请求参数

```json
{
  "userName": "string",
  "userPassword": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object|false|none|
|» userName|body|string|true|none|
|» userPassword|body|string|true|none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "message": "成功",
  "data": {
    "usedSpace": 0,
    "totalSpace": 10485760,
    "userName": "string",
    "userId": 1499291676721135600,
    "token": "eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJSCnD00w0Ndg1S0lFKrShQsjI0MzEzMTU3NDTWUSotTi3yTAEqMjSxtDSyNDQzNzM3AsqYmhmaK0Gk_RJzU4EKikuKMvPSlWoBjOvn9FYAAAA.Csa-UhwT3bur9C2eELPd6Sj41WRxiV3oiyF9Dm23k0BiOAq3JqpbubP58gY3OtbMGRUr8GceQBTSBjJ8-Q6nPQ"
  },
  "ok": true
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

## POST 注册

POST /:14308/api/user/signup

> Body 请求参数

```json
{
  "userName": "string",
  "userPassword": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object|false|none|
|» userName|body|string|true|none|
|» userPassword|body|string|true|none|

> 返回示例

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

# 数据模型

