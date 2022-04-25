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
   - 기본 사용법은 위와 같이 결합레이아웃을 만들고 씁니다.
   - 이번 과제에 저도 데이터 바인딩 사용했습니다.. 물론 결합레이아웃 장점은 못살림..ㅎ
   - 다양한 표현식을 제공합니다.
  <br>

- **MVVM**

  패키지 구조를 보면 알 수 있다시피.. 썼어요.. 썼다구요..
  사용한 AAC로는 `DataBinding, Room, ViewModel`이 있고, DI로는 `Hilt`를 사용했습니다..!
  StateFlow를 넣어놓긴했는데... 직접 사용하는 건 다음주 쯤에나.. 할라구여...
  
<br>

## :two: Second Week

<table class="tg">
<tbody>
    <tr>
      <td><b>Follower</b></td>
      <td><b>Repository</b></td>
    </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/70698151/164737567-789e5d49-8b52-4e31-a1d7-24dba0b7ca9f.png" width="300px"/></td>
    <td><img src="https://user-images.githubusercontent.com/70698151/164737577-96163819-c766-4974-ae45-e33ecca7fcf0.png"  width="300px"/></td>
	</tr>
</tbody>
</table>

<br>


#### 1. Level 1 :baby:
##### 필수과제 1-1
- ##### Home 프래그먼트 전환 코드(확장함수로 리플레이스구현)
    ```kotlin
        binding.btnFollower.setOnClickListener {
            replace(R.id.container_home, FollowerFragment())
        }

        binding.btnRepo.setOnClickListener {
            replace(R.id.container_home, RepositoryFragment())
        }
    ```
- ##### Repository 리스트 코드
    ```kotlin
    private fun initAdapter() {
        repositoryAdapter = HomeAdapter(requireActivity().layoutInflater, REPO)
        binding.rvRepository.adapter = repositoryAdapter
    }
    ```
    
- ##### Follwer 리스트 코드
    ```kotlin
    private fun initAdapter() {
        followerAdapter = HomeAdapter(requireActivity().layoutInflater, HomeAdapter.FOLLOWER)
        binding.rvFollower.adapter = followerAdapter
    }
    ```
    
#### 3. Level 3 :baby:
##### 심화과제 3-1
BindingActivity, BindingFragment를 사용해 보일러플레이트 축소
    
        
##### 심화과제 3-2
- DiffUtil 활용해서 변경 적용 효율적으로하기
    
class ItemDiffCallback<T : Any>(
    val onItemsTheSame: (T, T) -> Boolean,
    val onContentsTheSame: (T, T) -> Boolean
) : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = onItemsTheSame(oldItem, newItem)
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        onContentsTheSame(oldItem, newItem)
}
    
    
    
    
    
    
