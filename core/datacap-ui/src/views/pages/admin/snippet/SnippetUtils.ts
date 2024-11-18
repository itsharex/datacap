import { computed } from 'vue'
import { useI18n } from 'vue-i18n'

export function useHeaders()
{
    const { t } = useI18n()

    const headers = computed(() => [
        { key: 'id', label: t('common.id') },
        { key: 'name', label: t('common.name') },
        { key: 'description', label: t('common.description') },
        { key: 'username', label: t('common.username'), slot: 'username' },
        { key: 'createTime', label: t('common.createTime') },
        { key: 'updateTime', label: t('common.updateTime') },
        { key: 'action', label: t('common.action'), slot: 'action' }
    ])

    return {
        headers
    }
}
