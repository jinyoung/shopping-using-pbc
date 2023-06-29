<template>
    <div style="margin: 0 -15px 0 -15px;">
        <v-card-title v-if="editMode">
            {{label}}
        </v-card-title>
        <v-card-text v-if="value">
            <div v-if="!editMode">
                <v-rating color="warning" readonly v-model="value.averageRate" @input="sendRating()"></v-rating>
            </div>
        </v-card-text>
    </div>
</template>

<script>
    const axios = require('axios').default;

    export default {
        name:"Rating",
        props: {
            editMode: Boolean,
            value : Object,
            label : String,
        },
        async created(){
                try{
                    let data = await axios.get(axios.fixUrl('/ratings/' + this.value.topicId));
                    this.value = data.data;

                }catch(e){

                    this.value = {
                        'rate': 0,
                    };

                }

        },
        watch: {
            value(newVal) {
                this.$emit('input', newVal);
            },
            sendRating(rate){
                this.value.rate = rate;
                axios.put(axios.fixUrl(`/ratings/${this.value.topicId}/rate`), this.value.averageRate);
            }
        },
    }
</script>

<style scoped>
</style>