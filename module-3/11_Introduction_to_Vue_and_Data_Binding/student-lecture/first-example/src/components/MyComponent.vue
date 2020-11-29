<template> 
  <div>This is my component {{`You can do expressions in here now.`}} <p>{{msg}}</p></div>
</template>

<script>
export default {
    props: {
        msg: String
    }

}
</script>

 <style scoped> /*adding this keyword means that these rules apply to ONLY this component*/

div {
    width: 100px;
    height: 100px;
    background-color: tan;

}

</style>