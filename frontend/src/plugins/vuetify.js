import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

export default new Vuetify({
    theme: {
        light: true,
        themes: {
            light: {
                surface:'',
                primary: '',
                'primary-darken-1': '',
                secondary: '',
                'secondary-darken-1': '',
                info: '',
                error: '',
                warning: '',
                success: '',
            },
        },
    },
});
