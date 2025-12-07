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
		long long result = 0;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			char ch = str[i];
			int value = 0;
			switch (ch)
			{
			case '-':
				value = 0;
				break;
			case '\\':
				value = 1;
				break;
			case '(':
				value = 2;
				break;
			case '@':
				value = 3;
				break;
			case '?':
				value = 4;
				break;
			case '>':
				value = 5;
				break;
			case '&':
				value = 6;
				break;
			case '%':
				value = 7;
				break;
			case '/':
				value = -1;
				break;
			default:
				break;
			}
			result += value * std::pow(8, len - i - 1);
		}
		std::cout << result << "\n";
	}
	

	
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}