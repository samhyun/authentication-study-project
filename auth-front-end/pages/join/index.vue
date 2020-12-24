<template>
  <div class="mt-10 sm:mt-0 flex justify-center">
    <div class="w-2/3">
<!--      <form>-->

<!--        <div class="col-span-6 sm:col-span-3">-->
<!--          <text-field type="password" v-model="user.password" label="비밀번호" required pattern="^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%]).{6,}$"></text-field>-->
<!--        </div>-->
<!--        <button type="submit">test</button>-->
<!--      </form>-->
      <form @submit.prevent="save">
        <div class="shadow overflow-hidden sm:rounded-md">
          <div class="px-4 py-5 bg-white sm:p-6">
            <div class="text-2xl mb-5">기본 정보</div>
            <div class="grid grid-cols-6 gap-6">
              <div class="col-span-5">
                <text-field type="email" v-model="user.email" label="이메일" @input="isValid.email = false"
                            required></text-field>
              </div>

              <div class="flex justify-end items-end">
                <s-btn color="blue" dark @click="checkValidate('email', user.email)">
                  중복체크
                </s-btn>
              </div>

              <div class="col-span-6 sm:col-span-3">
                <text-field type="password" v-model="user.password" label="비밀번호" required pattern="^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%]).{6,}$"></text-field>
              </div>

              <div class="col-span-6 sm:col-span-3">
                <text-field type="password" v-model="user.confirmPassword" label="비밀번호 확인" required></text-field>
              </div>

              <div class="col-span-6 sm:col-span-3">
                <text-field v-model="user.lastName" label="성" required></text-field>
              </div>

              <div class="col-span-6 sm:col-span-3">
                <text-field v-model="user.firstName" label="이름" required></text-field>
              </div>

              <div class="col-span-6 sm:col-span-2">
                <text-field v-model="user.nickname" label="닉네임" required @input="isValid.nickname = false"></text-field>
              </div>

              <div class="flex justify-end items-end">
                <s-btn color="blue" dark @click="checkValidate('nickname', user.nickname)">
                  중복체크
                </s-btn>
              </div>

              <div class="col-span-6 sm:col-span-3">
                <text-field v-model="user.mobile" label="휴대전화 번호" required></text-field>
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
            <s-btn color="blue" dark :disabled="disabledSaveButton" type="submit">
              Save
            </s-btn>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import {mapActions, mapState} from 'vuex';
import User from '@/domain/user/user';

export default {
  name: 'join',
  computed: {
    ...mapState({
      todo: state => state.todos.list
    }),
    errorMessage() {
      const messages = {
        INVALID_EMAIL_FORMAT: '유효하지 않은 메일 형식입니다.',
        EXISTS_EMAIL: '이미 가입된 이메일입니다.',
        INVALID_NICKNAME_FORMAT: '유효하지 않은 닉네임 형식입니다.',
        EXISTS_NICKNAME: '이미 가입된 닉네임입니다.'
      };
      return messages[this.errorCode];
    },
    invalidPassword() {
      return this.user.password !== this.user.confirmPassword;
    },
    disabledSaveButton() {
      return Object.keys(this.isValid).some(key => !this.isValid[key]) || this.invalidPassword;
    }
  },
  data() {
    return {
      user: new User(),
      isValid: {
        email: false,
        nickname: false
      },
      errorCode: ''
    };
  },
  methods: {
    async checkValidate(type, value) {
      try {
        this.isValid[type] = await this.$api.user.isValid(type, value);
        alert('사용가능합니다.');
      } catch (e) {
        this.errorCode = e;
        this.alertErrorMessage();
      }
    },
    async save() {
      await this.$api.auth.join(this.user);
    },
    alertErrorMessage() {
      alert(this.errorMessage);
    }
  }

};
</script>

<style scoped>

</style>