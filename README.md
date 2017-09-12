A sample of app server,use spring boot.

# API List

* login

  | mothod |            url            | token |
  | :----: | :-----------------------: | :---: |
  |  POST  | http:host:8080/api/logout |  no   |

  Params

  |   name   |  type  | required |
  | :------: | :----: | :------: |
  |   name   | string |   yes    |
  | password | string |   yes    |

  ​

* logout

  | method |            url            | token |
  | :----: | :-----------------------: | :---: |
  | DELETE | http:host:8080/api/logout |  yes  |

  ​

* register

  | method |             url             | token |
  | :----: | :-------------------------: | :---: |
  |  POST  | http:host:8080/api/register |  no   |

  Params

  |   name   |  type  | required |
  | :------: | :----: | :------: |
  |  phone   | string |   yes    |
  | password | string |   yes    |

  ​

  ​