<template>
  <div class="container">
    <h5 class="text-success">Billing</h5>
    <br />
    <h5 v-if="!details.length" class="text-danger">No Billing is Done yet.</h5>
    <table class="table table-stripped" v-if="details.length">
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
import DataService from '../auth-axios';

export default {
  data(){
    return{
      details:[],
    }
  },
  methods:{
    getDetails(){
    DataService.retrieveAllBilling().then((res)=>{
      const data=res.data;
      const users=[];
      for(let key in data){
        const user=data[key];
        users.push(user);
      }
      this.details=user;
    })
  }
  },
  created(){
    this.getDetails();
  }
};
</script>