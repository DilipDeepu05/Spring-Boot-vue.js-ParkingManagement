<template>
  <div class="container">
    <h5 class="text-success">Bill</h5>
    <br />

    <table class="table table-stripped">
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Entry Time</th>
          <th>Exit Time</th>
          <th>Amount</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="c in customers" :key="c.id">
          <td>{{c.id}}</td>
          <td>{{c.name}}</td>
          <td>{{new Date(c.login).toUTCString()}}</td>
          <td>{{new Date(c.logout).toUTCString()}}</td>
          <td>{{c.amount}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import DataService from "../auth-axios";

export default {
  data() {
    return {
      id: this.$route.params.id,
      details: [],
    };
  },
  methods: {
    getDetails() {
      this.details = [];
      DataService.actveBilling(this.id).then((res) => {
        const data = res.data;
        this.details.push(data);
      });
    },
  },
  created() {
    this.getDetails();
  },
};
</script>