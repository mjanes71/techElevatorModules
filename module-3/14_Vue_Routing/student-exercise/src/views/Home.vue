<template>
<div>
    <div>
        <best-seller-list></best-seller-list>
    </div>
    <div>
         <new-releases-list></new-releases-list>
    </div>
    
</div>
  
</template>

<script>
import BestSellerList from '@/components/BestSellerList.vue';
import NewReleasesList from '@/components/NewReleasesList.vue';
export default {
    components: {
        BestSellerList, NewReleasesList
    }

}
</script>

<style>

</style>