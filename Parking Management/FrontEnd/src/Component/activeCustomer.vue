<template>
  <div class="container">
    <h5 class="text-success">List of Active Customer</h5>
    <br />
    <table class="table table-stripped">
      <thead>
        <tr>
          <th>Firstname</th>
          <th>Lastname</th>
          <th>Email</th>
          <th>Entry Time</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="c in customers" :key="c.id">
          <td v-if="c.login">{{c.firstname}}</td>
          <td v-if="c.login">{{c.lastname}}</td>
          <td v-if="c.login">{{c.email}}</td>
          <td v-if="c.login">{{new Date(c.login).toUTCString()}}</td>
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