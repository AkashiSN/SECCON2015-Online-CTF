
./libcalc.so:     ファイル形式 elf32-i386


セクション .plt の逆アセンブル:

00000300 <__cxa_atexit@plt-0x10>:
 300:	ff b3 04 00 00 00    	push   DWORD PTR [ebx+0x4]
 306:	ff a3 08 00 00 00    	jmp    DWORD PTR [ebx+0x8]
 30c:	00 00                	add    BYTE PTR [eax],al
	...

00000310 <__cxa_atexit@plt>:
 310:	ff a3 0c 00 00 00    	jmp    DWORD PTR [ebx+0xc]
 316:	68 00 00 00 00       	push   0x0
 31b:	e9 e0 ff ff ff       	jmp    300 <__cxa_atexit@plt-0x10>

00000320 <__stack_chk_fail@plt>:
 320:	ff a3 10 00 00 00    	jmp    DWORD PTR [ebx+0x10]
 326:	68 08 00 00 00       	push   0x8
 32b:	e9 d0 ff ff ff       	jmp    300 <__cxa_atexit@plt-0x10>

00000330 <__cxa_finalize@plt>:
 330:	ff a3 14 00 00 00    	jmp    DWORD PTR [ebx+0x14]
 336:	68 10 00 00 00       	push   0x10
 33b:	e9 c0 ff ff ff       	jmp    300 <__cxa_atexit@plt-0x10>

セクション .text の逆アセンブル:

00000340 <Java_com_example_seccon2015_rock_1paper_1scissors_MainActivity_calc-0xc0>:
 340:	53                   	push   ebx
 341:	e8 aa 00 00 00       	call   3f0 <__cxa_finalize@plt+0xc0>
 346:	81 c3 a2 1c 00 00    	add    ebx,0x1ca2
 34c:	8d 64 24 e8          	lea    esp,[esp-0x18]
 350:	8d 83 18 00 00 00    	lea    eax,[ebx+0x18]
 356:	89 04 24             	mov    DWORD PTR [esp],eax
 359:	e8 d2 ff ff ff       	call   330 <__cxa_finalize@plt>
 35e:	8d 64 24 18          	lea    esp,[esp+0x18]
 362:	5b                   	pop    ebx
 363:	c3                   	ret    
	...
 370:	8d 64 24 f4          	lea    esp,[esp-0xc]
 374:	8b 44 24 10          	mov    eax,DWORD PTR [esp+0x10]
 378:	85 c0                	test   eax,eax
 37a:	74 02                	je     37e <__cxa_finalize@plt+0x4e>
 37c:	ff d0                	call   eax
 37e:	8d 64 24 0c          	lea    esp,[esp+0xc]
 382:	c3                   	ret    
 383:	8d b6 00 00 00 00    	lea    esi,[esi+0x0]
 389:	8d bc 27 00 00 00 00 	lea    edi,[edi+eiz*1+0x0]
 390:	53                   	push   ebx
 391:	e8 5a 00 00 00       	call   3f0 <__cxa_finalize@plt+0xc0>
 396:	81 c3 52 1c 00 00    	add    ebx,0x1c52
 39c:	8d 64 24 e8          	lea    esp,[esp-0x18]
 3a0:	8d 83 18 00 00 00    	lea    eax,[ebx+0x18]
 3a6:	89 44 24 08          	mov    DWORD PTR [esp+0x8],eax
 3aa:	8b 44 24 20          	mov    eax,DWORD PTR [esp+0x20]
 3ae:	89 44 24 04          	mov    DWORD PTR [esp+0x4],eax
 3b2:	8d 83 88 e3 ff ff    	lea    eax,[ebx-0x1c78]
 3b8:	89 04 24             	mov    DWORD PTR [esp],eax
 3bb:	e8 50 ff ff ff       	call   310 <__cxa_atexit@plt>
 3c0:	8d 64 24 18          	lea    esp,[esp+0x18]
 3c4:	5b                   	pop    ebx
 3c5:	c3                   	ret    
 3c6:	8d 76 00             	lea    esi,[esi+0x0]
 3c9:	8d bc 27 00 00 00 00 	lea    edi,[edi+eiz*1+0x0]
 3d0:	53                   	push   ebx
 3d1:	e8 1a 00 00 00       	call   3f0 <__cxa_finalize@plt+0xc0>
 3d6:	81 c3 12 1c 00 00    	add    ebx,0x1c12
 3dc:	8d 64 24 f8          	lea    esp,[esp-0x8]
 3e0:	e8 3b ff ff ff       	call   320 <__stack_chk_fail@plt>
 3e5:	8d 64 24 08          	lea    esp,[esp+0x8]
 3e9:	5b                   	pop    ebx
 3ea:	c3                   	ret    
 3eb:	90                   	nop
 3ec:	8d 74 26 00          	lea    esi,[esi+eiz*1+0x0]
 3f0:	8b 1c 24             	mov    ebx,DWORD PTR [esp]
 3f3:	c3                   	ret    
 3f4:	90                   	nop
 3f5:	8d b4 26 00 00 00 00 	lea    esi,[esi+eiz*1+0x0]
 3fc:	00 00                	add    BYTE PTR [eax],al
	...

00000400 <Java_com_example_seccon2015_rock_1paper_1scissors_MainActivity_calc>:
 400:	b8 07 00 00 00       	mov    eax,0x7
 405:	c3                   	ret    
