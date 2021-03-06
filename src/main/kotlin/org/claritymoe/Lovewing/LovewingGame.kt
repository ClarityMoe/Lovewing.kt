/*
 *    Copyright 2018 ClarityMoe
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.claritymoe.Lovewing

import com.badlogic.gdx.Screen
import ktx.app.KtxGame
import org.claritymoe.Lovewing.screens.MainScreen

class LovewingGame : KtxGame<Screen>() {
    override fun create() {
        addScreen(MainScreen())

        setScreen<MainScreen>()
    }
}