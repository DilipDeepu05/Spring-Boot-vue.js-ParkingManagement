<template>
  <div>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
      <a class="navbar-brand" style="{color:blue}">PARKING MANAGEMENT</a>
      <ul class="navbar-nav">
        <router-link class="nav-link" tag="li" to="/" activeClass="active">
          <a>Home</a>
        </router-link>
        <router-link class="nav-link" tag="li" to="/Customer" activeClass="active">
          <a>Customers List</a>
        </router-link>
        <router-link class="nav-link" tag="li" to="/Active" activeClass="active">
          <a>Active Customers</a>
        </router-link>
        <router-link class="nav-link" tag="li" to="/Billing" activeClass="active">
          <a>Billing</a>
        </router-link>
      </ul>
    </nav>
    <div class="container">
      <h3 class="text-primary">PARLING MANAGEMENT</h3>
      <hr />
    </div>
  </div>
</template>

<style scoped>
nav {
  cursor: pointer;
}
</style>
        