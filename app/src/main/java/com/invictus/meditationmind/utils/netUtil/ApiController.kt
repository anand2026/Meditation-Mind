package com.invictus.meditationmind.utils.netUtil

import com.invictus.meditationmind.utils.netUtil.RetrofitInstance.mRetrofit

object ApiController {

    var mApiInterface: ApiWithParamsCalls = mRetrofit.create(ApiWithParamsCalls::class.java)

}