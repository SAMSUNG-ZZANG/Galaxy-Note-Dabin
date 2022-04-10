# Galaxy-Note-Dabin
나는 오늘도 한다. 과제.
## :one: First Week

<table class="tg">
<tbody>
    <tr>
      <td><b>Sign In</b></td>
      <td><b>Sign Up</b></td>
      <td><b>Home</b></td>
    </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/70698151/162624575-e82b2b4a-a45d-471e-a6d5-353fb089b611.png" width="300px"/></td>
    <td><img src="https://user-images.githubusercontent.com/70698151/162624588-dfecaf1f-e606-4b9f-b309-7be900c70d4c.png"  width="300px"/></td>
  	<td><img src="https://user-images.githubusercontent.com/70698151/162624562-07c33265-9716-4ece-ba18-9ec12d9a3b18.png"  width="300px"/></td>
	</tr>
</tbody>
</table>

<br>

#### 1. Level 1 :baby:

- ##### Sign Up

  - **회원가입 버튼 클릭 시 세 개의 EditText가 채워져있는지 확인**

    ```kotlin
    private fun isAllEditTextEmpty() : Boolean {
         return isEtNameEmpty() || isEtIdEmpty() || isEtPassword()
    }
    
    private fun isEtNameEmpty() : Boolean {
        return binding.etName.text.isNullOrEmpty()
    }
    
    private fun isEtIdEmpty() : Boolean {
        return binding.etId.text.isNullOrEmpty()
    }
    
    private fun isEtPassword() : Boolean {
        return binding.etPassword.text.isNullOrEmpty()
    }
    
    // 빈칸 출력용 shortToast
    binding.btnSignUp.setOnClickListener {
            if (isAllEditTextEmpty())
                shortToast(getString(R.string.is_empty))
    }
    ```

<br>
- ##### Sign In

  - **빈 칸 확인**

    ```kotlin
    private fun isEtIdEmpty() : Boolean {
        return binding.etId.text.isNullOrEmpty()
    }
    
    private fun isEtPasswordEmpty() : Boolean {
        return binding.etPassword.text.isNullOrEmpty()
    }
    
    // 빈칸 출력용 shortToast
    binding.btnSignIn.setOnClickListener {
            when (isEtIdEmpty() || isEtPasswordEmpty()) {
                true -> shortToast("아이디/비밀번호를 확인해주세요")
                else -> startHomeActivity()
            }
    }
    ```


<br>

- ##### Sign In

  - **빈 칸 확인**

    ```kotlin
    private fun isEtIdEmpty() : Boolean {
        return binding.etId.text.isNullOrEmpty()
    }
    
    private fun isEtPasswordEmpty() : Boolean {
        return binding.etPassword.text.isNullOrEmpty()
    }
    ```
    
    
  - **inputType 패스워드 & hint 속성 활용**

    ```xml
            android:inputType="textPassword"
            android:hint="@string/fill_pass"
    ```
<br>

- ##### Home
레이아웃만 짰습니다.. 사진 참조

##### :bulb: 이번 과제를 통해 배운내용

- 멀티모듈 만드는 법을 배웠던 것 같아요.. 다음엔 좀 더 디벨롭시키는걸로..

<br>

#### 2. Level 2 👧
- **registerForActivityResult(데이터 수신 부분)**

    ```kotlin
    private val requestIdAndPassActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
        if(activityResult.resultCode == Activity.RESULT_OK) {
            val intent = activityResult.data
            if (intent != null) {
                binding.etId.setText(intent.extras?.getString("id"))
                binding.etPassword.setText(intent.extras?.getString("password"))
            }
        }
        else {
            binding.etId.text.clear()
            binding.etPassword.text.clear()
        }
    }
    ```

- **set Result 부분**

    ```kotlin
    private fun initClickEvent() {
        binding.btnSignUp.setOnClickListener {
        if (isAllEditTextEmpty())
                shortToast(getString(R.string.is_empty))
            else {
            val name = binding.etName.text.toString()
                val id = binding.etEmail.text.toString()
                val password = binding.etPassword.text.toString()

                viewModel.insertUserData(User(name, id, password))

                setResult(
                    Activity.RESULT_OK, Intent().apply {
                        putExtra("name", name)
                        putExtra("id", id)
                        putExtra("password", password)
                    }
                )
               }
        }
    ```

- **Scroll View 홈에서 사용**

  ```xml
          <ScrollView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layout_constraintTop_toTopOf="parent">

  ```
  - **DimensionRatio
  
  - **constraintDimensionRatio(1대1 비율)**

    ```xml
    
                <ImageView
                    android:id="@+id/iv_owner"
                    android:layout_width="@dimen/login_logo_size"
                    android:layout_height="0dp"
                    android:layout_marginTop="120dp"
                    android:background="@drawable/img_pika"
                    app:layout_constraintDimensionRatio="1:1"
                    app:layout_constraintEnd_toEndOf="parent"
                    app:layout_constraintStart_toStartOf="parent"
                    app:layout_constraintTop_toTopOf="parent" />
    ```

<br>

#### 3. Level 3 :woman:

- **DataBinding이란?**

  :arrow_right: 사용하는 데이터를 뷰에 바인딩하는 방식의 바인딩.

  
    ```xml    
  <layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>

    </data>
  </layout>
    ```
기본 사용법은 위와 같습니다.
  <br>

- **MVVM**
  패키지 구조를 보면 알 수 있다시피.. 썼어요.. 썼다구요..

<br>
