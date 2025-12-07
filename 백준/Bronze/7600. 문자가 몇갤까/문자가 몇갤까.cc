#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {


	while (true) {
		std::string str;
		std::getline(std::cin, str);
		if (str == "#") break;
		int cnt = 0;
		bool arr[26] = { false, };
		for (char &c : str) {
			if (isupper(c)) c = tolower(c);
			if (c >= 'a' && c <= 'z') {
				arr[c - 'a'] = true;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (arr[i]) cnt++;
		}
		std::cout << cnt << "\n";
	}



}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}