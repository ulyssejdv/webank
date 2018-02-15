# Data Access Service

__Context Path__ : /data-access-service

__Port__ : 25000

## API Endpoint

__[GET] /bank-statement/{bankStatementId}__

Get one bank-statement metadata for the given id

* Content Type : application/json
* Body : BankStatementDto

`{"id":1,"fileName":"bas_1.pdf","createdAt":1506604288454}`

* Responde Code : 200

Erreurs :

* 204 : No Content

___

__[GET] /bank-statement/customer/{customerId}__

Get all bank-statement metadata for the given customer

* Content Type : application/json
* Body :

```
[
    {
        "id": 1,
        "fileName": "bas_1.pdf",
        "createdAt": 1506604288454
    },
    {
        "id": 4,
        "fileName": "bas_4.pdf",
        "createdAt": 1509196288454
    },
    {
        "id": 7,
        "fileName": "bas_7.pdf",
        "createdAt": 1511874688454
    },
    {
        "id": 10,
        "fileName": "bas_10.pdf",
        "createdAt": 1514466688454
    }
]
```

* Responde Code : 200

Erreurs :

* 204 : No Content