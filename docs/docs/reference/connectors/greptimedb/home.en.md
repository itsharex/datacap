---
title: GreptimeDB
status: new
---

<img src="/assets/plugin/greptimedb.svg" class="connector-content-logo" />

#### What is GreptimeDB ?

An open-source, cloud-native, distributed time-series database with PromQL/SQL/Python supported.

#### Environment

!!! note

    If you need to use this data source, you need to upgrade the DataCap service to >= `1.9.x`

Support Time: `2023-04-14`

#### Configure

---

!!! note

    If your GreptimeDB service version requires other special configurations, please refer to modifying the configuration file and restarting the DataCap service.

=== "Configure"

    | Field  |             Required              | Default Value |
    |:------:|:---------------------------------:|:-------------:|
    | `Name` | :material-check-circle: { .red }  |       -       |
    | `Host` | :material-check-circle:  { .red } |  `127.0.0.1`  |
    | `Port` | :material-check-circle:  { .red } |    `4000`     |

#### Version (Validation)

---

!!! warning

    The online service has not been tested yet, if you have detailed test results, please submit [issues](https://github.com/EdurtIO/datacap/issues/new/choose) to us

- [x] 0.x
