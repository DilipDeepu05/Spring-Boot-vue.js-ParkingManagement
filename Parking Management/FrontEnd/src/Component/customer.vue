<template>
  <div class="container">
    <h5 class="text-success">List of Customer</h5>
    <br />
    <table class="table table-stripped">
      <thead>
        <tr>
          <th>Id</th>
          <th>Firstname</th>
          <th>Lastname</th>
          <th>Email</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="c in customers" :key="c.id">
          <td>{{c.id}}</td>
          <td>{{c.firstname}}</td>
          <td>{{c.lastname}}</td>
          <td>{{c.email}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import { customer } from "../mixins/customers";
export default {
  mixins: [customer],
};
</script>