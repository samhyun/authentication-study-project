<template>
  <div class="mt-10 sm:mt-0 flex justify-center">
    <div class="w-2/3">
      <form action="#" method="POST">
        <div class="shadow overflow-hidden sm:rounded-md">
          <div class="px-4 py-5 bg-white sm:p-6">
            <div class="text-2xl mb-5">기본 정보</div>
            <div class="grid grid-cols-6 gap-6">
              <div class="col-span-6">
                <text-field type="email" v-model="user.email" label="이메일"></text-field>
              </div>

              <div class="col-span-6 sm:col-span-3">
                <text-field type="password" v-model="user.password" label="비밀번호"></text-field>
              </div>

              <div class="col-span-6 sm:col-span-3">
                <text-field type="password" v-model="user.confirmPassword" label="비밀번호 확인"></text-field>
              </div>

              <div class="col-span-6 sm:col-span-2">
                <text-field type="text" v-model="user.lastName" label="성"></text-field>
              </div>

              <div class="col-span-6 sm:col-span-2">
                <text-field type="text" v-model="user.firstName" label="이름"></text-field>
              </div>

              <div class="col-span-6 sm:col-span-2">
                <text-field v-model="user.nickname" label="닉네임"></text-field>
              </div>

              <div class="col-span-6 sm:col-span-3">
                <text-field v-model="user.mobile" label="휴대전화 번호"></text-field>
              </div>


<!--              <div class="col-span-6 sm:col-span-3">-->
<!--                <select id="country" name="country" autocomplete="country"-->
<!--                        class="mt-1 block w-full py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">-->
<!--                  <option>United States</option>-->
<!--                  <option>Canada</option>-->
<!--                  <option>Mexico</option>-->
<!--                </select>-->
<!--              </div>-->

<!--              <div class="col-span-6">-->
<!--                <text-field v-model="user.lastName" label="lastName"></text-field>-->
<!--              </div>-->

<!--              <div class="col-span-6 sm:col-span-6 lg:col-span-2">-->
<!--                <text-field v-model="user.lastName" label="lastName"></text-field>-->
<!--              </div>-->

<!--              <div class="col-span-6 sm:col-span-3 lg:col-span-2">-->
<!--                <text-field v-model="user.lastName" label="lastName"></text-field>-->
<!--              </div>-->

<!--              <div class="col-span-6 sm:col-span-3 lg:col-span-2">-->
<!--                <text-field v-model="user.lastName" label="lastName"></text-field>-->
<!--              </div>-->
            </div>
          </div>
          <div class="px-4 py-3 bg-gray-50 text-right sm:px-6">
            <s-btn color="blue" dark>
              Save
            </s-btn>
<!--            <button type="submit"-->
<!--                    class="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">-->
<!--              Save-->
<!--            </button>-->
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import {mapState} from 'vuex';
import User from '@/domain/user/user';

export default {
  name: 'join',
  computed: mapState({
    todo: state => state.todos.list,
    testTodo(state) {
      return state.todos.list[0] + this.user.email;
    }
  }),
  data() {
    return {
      user: new User()

    };
  },
  created() {
  }
};
</script>

<style scoped>

</style>