/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.code_assignment_one.data

import com.example.code_assignment_one.R
import com.example.code_assignment_one.model.Crypto


/**
 * [Datasource] generates a list of [Crypto]
 */
object Datasource {
    val tokenList = listOf(
        Crypto(R.drawable.xrp_token, 4, 0),
        Crypto(R.drawable.bitcoin, 150000, 10),
        Crypto(R.drawable.hbar, 15, 20)
    )
}
