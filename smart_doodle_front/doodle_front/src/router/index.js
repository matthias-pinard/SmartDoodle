import Vue from 'vue'
import Router from 'vue-router'
import Event from '@/components/Event'
import Date from '@/components/Date'
import Creator from '@/components/Creator'
import Poll from '@/components/Poll'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/create',
            component: Event
        },
        {
            path: '/create/:id/date',
            name: 'date',
            component: Date
        },
        {
            path: '/create/:id/creator',
            name: 'creator',
            component: Creator
        },
        {
            path: '*',
            redirect: '/create'
        },
        {
            path: '/poll/:id',
            name: 'poll',
            component: Poll
        }
    ]
})