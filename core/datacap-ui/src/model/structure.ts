export interface StructureModel
{
    title?: null | string
    catalog?: null
    database?: null | any
    databaseId?: string
    table?: null
    tableId?: null
    applyId?: null | number
    type?: null
    dataType?: string
    extra?: string
    engine?: string
    level?: null | StructureEnum
    loading?: false
    render?: any
    isKey?: null
    defaultValue?: null
    comment?: null
    origin?: any
    selected?: boolean
    contextmenu?: true
    children?: StructureModel[]
}

export enum StructureEnum
{
    CATALOG,
    DATABASE,
    TABLE,
    COLUMN
}
