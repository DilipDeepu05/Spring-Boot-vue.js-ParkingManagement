<template>
  <div class="container">
    <h5 class="text-success">Add New Customer</h5>
    <br />
    <form method="post" @submit="formData">
      <div class="form-group">
        <label>First Name</label>
        <input
          type="text"
          class="form-control"
          minlength="2"
          v-model="customer.firstname"
          placeholder="First Name"
        />
      </div>
      <div class="form-group">
        <label>Last Name</label>
        <input
          type="text"
          class="form-control"
          minlength="2"
          v-model="customer.lastname"
          placeholder="Last Name"
        />
      </div>
      <div class="form-group">
        <label>Email</label>
        <input
          type="email"
          class="form-control"
          minlength="2"
          v-model="customer.email"
          placeholder="Email"
        />
      </div>
      <button
        class="btn btn-primary"
        :disabled="!customer.firstname || !customer.lastname || !customer.email"
      >Submit</button>
    </form>
  </div>
</template>

<script>
import DataService from "../axios-auth";

export default {
  data() {
    return {
      customer: {
        id: 0,
        firstname: "",
        lastname: "",
        email: "",
        login: null,
        logout: null,
      },
    };
  },
  methods: {
    formData() {
      DataService.updateCustomer(this.customer);
      this.$router.push("/");
    },
  },
};
</script>