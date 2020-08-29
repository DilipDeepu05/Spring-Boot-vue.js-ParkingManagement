<template>
  <div class="container">
    <div v-if="!searchCustomer">
      <div class="side">
        <h5 class="text-success">{{date}}</h5>
      </div>
      <br />
      <br />
      <br />
      <br />
      <button class="btn btn-danger" @click="addCustomer">New Customer</button>
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <form method="POST" @submit="searchById">
        <label class="text-danger">
          <b>Enter the Customer id:</b>
        </label>
        <input type="number" v-model="search" placeholder="Search customer" required />
        <button>
          <svg
            width="2em"
            height="2em"
            viewBox="0 0 16 16"
            class="bi bi-search"
            fill="currentColor"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fill-rule="evenodd"
              d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z"
            />
            <path
              fill-rule="evenodd"
              d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"
            />
          </svg>
        </button>
      </form>
      <br />
      <br />
    </div>
    <div v-if="searchCustomer" :style="{tableWidth:30+'%'}">
      <h5 class="text-success">Customer clock In/Out</h5>
      <br />
      <h6>Customer Id: {{customer.id}}</h6>
      <h6>Customer Name: {{customer.firstname}}</h6>
      <h4 v-if="!customer.login">Web Clock In</h4>
      <h4 v-if="!customer.logout && customer.login">Web Clock Out</h4>

      <p v-if="!customer.login">
        {{customer.login ? new Date(customer.login).toUTCString(): ''}}
        <button @click="Inout">
          <svg
            width="3em"
            height="3em"
            viewBox="0 0 16 16"
            class="bi bi-alarm-fill"
            fill="currentColor"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fill-rule="evenodd"
              d="M5.5.5A.5.5 0 0 1 6 0h4a.5.5 0 0 1 0 1H9v1.07a7.002 7.002 0 0 1 3.537 12.26l.817.816a.5.5 0 0 1-.708.708l-.924-.925A6.967 6.967 0 0 1 8 16a6.967 6.967 0 0 1-3.722-1.07l-.924.924a.5.5 0 0 1-.708-.708l.817-.816A7.002 7.002 0 0 1 7 2.07V1H5.999a.5.5 0 0 1-.5-.5zM.86 5.387A2.5 2.5 0 1 1 4.387 1.86 8.035 8.035 0 0 0 .86 5.387zM13.5 1c-.753 0-1.429.333-1.887.86a8.035 8.035 0 0 1 3.527 3.527A2.5 2.5 0 0 0 13.5 1zm-5 4a.5.5 0 0 0-1 0v3.882l-1.447 2.894a.5.5 0 1 0 .894.448l1.5-3A.5.5 0 0 0 8.5 9V5z"
            />
          </svg>
        </button>
      </p>
      <p v-if="!customer.logout && customer.login">
        {{customer.logout ? new Date(customer.logout).toUTCString(): ''}}
        <button @click="Outin">
          <svg
            width="3em"
            height="3em"
            viewBox="0 0 16 16"
            class="bi bi-alarm-fill"
            fill="currentColor"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fill-rule="evenodd"
              d="M5.5.5A.5.5 0 0 1 6 0h4a.5.5 0 0 1 0 1H9v1.07a7.002 7.002 0 0 1 3.537 12.26l.817.816a.5.5 0 0 1-.708.708l-.924-.925A6.967 6.967 0 0 1 8 16a6.967 6.967 0 0 1-3.722-1.07l-.924.924a.5.5 0 0 1-.708-.708l.817-.816A7.002 7.002 0 0 1 7 2.07V1H5.999a.5.5 0 0 1-.5-.5zM.86 5.387A2.5 2.5 0 1 1 4.387 1.86 8.035 8.035 0 0 0 .86 5.387zM13.5 1c-.753 0-1.429.333-1.887.86a8.035 8.035 0 0 1 3.527 3.527A2.5 2.5 0 0 0 13.5 1zm-5 4a.5.5 0 0 0-1 0v3.882l-1.447 2.894a.5.5 0 1 0 .894.448l1.5-3A.5.5 0 0 0 8.5 9V5z"
            />
          </svg>
        </button>
      </p>
    </div>
  </div>
</template>

<script>
import DataService from "../auth-axios";

export default {
  data() {
    return {
      date: "",
      search: "",
      searchCustomer: false,
      customer: [],
    };
  },
  methods: {
    addCustomer() {
      this.$router.push("/AddCustomer");
    },
    searchById() {
      this.searchCustomer = true;
      DataService.retrieveCustomer(this.search).then((res) => {
        if (!res.data) {
          this.$router.push("/noCustomer");
        } else {
          const data = res.data;
          this.customer = data;
        }
      });
    },
    Inout() {
      this.customer.login = new Date();
      DataService.updateCustomer(this.customer);
      this.$router.push("/Active");
    },

    Outin() {
      this.customer.login = new Date();
      DataService.updateCustomer(this.customer);
      this.$router.push({
        name: "ActiveBilling",
        params: { id: this.customer.id },
      });
    },
  },
  mounted() {
    const interval = setInterval(() => {
      this.date = new Date().toLocaleTimeString();
    }, 1000);
    interval;
  },
};
</script>

<style scoped>
.side {
  float: right;
}
</style>