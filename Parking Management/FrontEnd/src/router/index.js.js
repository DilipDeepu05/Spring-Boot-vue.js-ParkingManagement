import { createRouter, createWebHistory } from 'vue-router';
import Home from '../Component/home.vue';
import Customer from '../Component/customer.vue';
import Billing from '../Component/Billing.vue';
import Active from '../Component/activeCustomer.vue';
import NoCustomer from '../Component/noCustomer.vue';
import AddCustomer from '../Component/AddCustomer.vue';
import ActiveBilling from '../Component/ActiveBilling.vue';

const routes = [
  { path: '/', component: Home },
  { path: '/Customer', component: Customer },
  { path: '/Billing', component: Billing },
  { path: '/Active', component: Active },
  { path: '/noCustomer', component: noCustomer },
  { path: '/AddCustomer', component: AddCustomer },
  {
    path: '/ActiveBilling/:id',
    name: 'ActiveBilling',
    component: ActiveBilling,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
