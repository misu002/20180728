<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <style>
        body {
            background-color: #f5f5f5;
        }

        #page {
            margin: 10px;
            width: 100%;
            height: 100%;
        }

        #banner {
            text-align: center;
            margin: 30px auto;
            font-size: 40px;
            color: green;
        }

        #content {
            margin: 0 auto;
            width: 500px;
            height: 1000px;
        }

        h4 {
            margin: 7px;
        }

        .big {
            margin: 5px;
            padding: 8px;
            width: 480px;
            height: 22px;
        }

        .small {
            margin: 5px;
            padding: 8px;
            height: 22px;
            width: 145px;
        }

        #Bmonth {
            height: 40px;
            width: 138px;
        }

        .gender {
            display: inline-block;
            text-align: center;
            line-height: 50px;
            width: 245px;
            height: 50px;
            background-color: white;
        }

        #address {
            height: 40px;
            width: 500px;
            padding: 5px;
            margin-left: 5px;
        }

        #tel {
            margin: 5px;
            padding: 8px;
            height: 22px;
            width: 320px;
        }

        .certify {
            border: none;
            background-color: #039803;
            width: 143px;
            height: 45px;
            margin-top: 5px;
            padding-bottom: 5px;
            color: white;
        }

        .last {
            background: #f5f5f5;
            border: 1px solid lightgray;
        }

        .final {
            margin-left: 8px;
            margin-top: 25px;
            padding: 8px;
            width: 495px;
            height: 70px;
            font-size: 25px;
        }

        input[type=radio] {
            display: none;
            width: 245px;
            height: 50px;
        }

        #msg {
            display: inline-block;
            background-color: #039803;
            width: 143px;
            height: 20px;
            padding: 10px 0px;
            text-align: center;
            color: white;
        }

        .spanLabel {
            width: 245px;
            height: 50px;
        }
        
        .photo{
			margin-left: 8px;
        }

    </style>
</head>
<body>
  <form action="register" method="post" enctype="multipart/form-data">
        <div id="page">
            <h1 id="banner">NAVER</h1>
            <div id="content">

                <h4>아이디</h4>
                <span id="chkId">
                <input type="text" class="big" id="id" name="id">
            <label for="id" class="idLabel"></label></span>
                <h4>비밀번호</h4>
                <span>
            <input type="password" class="big" id="pw" name="pw">
            <label for="pw" class="pwLabel"></label></span>
                <h4>비밀번호확인</h4>
                <span>
            <input type="password" class="big" id="pw2">
            <label for="pw2" class="pw2Label"></label></span>
                <h4>이름</h4>
                <span>
            <input type="text" class="big" id="name" name="name">
            <label for="name" class="nameLabel"></label></span>
                <h4>생년월일</h4>
                <span class="bdaySpan">
            <input type="text" class="small" placeholder="년(4자)" id="Byear" name="year">
            <label for="Bday" ></label>
                    
                <select id="Bmonth" name="month">
            <option value="">월</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            </select>
                    
                <input type="text" class="small" placeholder="일" id="Bday" name="day">
                    </span>
                <h4>성별</h4>
                <div class="gender"><input type="radio" id="male" name="gender" value="M"><span class="spanLabel"><label for="male">남성</label></span></div>
                <div class="gender"><input type="radio" id="female" name="gender" value="F"><span class="spanLabel"><label for="female">여성</label></span></div>
                <h4>본인 확인 이메일</h4>
                <span>
            <input type="text" class="big" id="selfCheck" name="email" placeholder="선택 입력">
                </span>
                <h4>휴대전화</h4>
                <select id="address" name="loc">
            <option value="+82">대한민국 +82</option>
                <option></option>
                <option></option>
                <option></option>
                <option></option>
                <option></option>
            </select>
                <span class="telSpan">
                <input id="tel" type="number" placeholder="전화번호 입력" name="phone">
                <label for="tel" class="telLabel"></label>                
                <div id="msg">인증번호받기</div>
                </span>
                <input class="big last" type="text" placeholder="인증번호 입력하세요">
                <div class="photo">사진 업로드</div>
                <input type="file" name="photoFile" id="photo" class="photo"/>
                <button class="certify final">가입하기</button>

            </div>
        </div>
    </form>
</body>
</html>