#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>


void solve() {

	int n;
	std::cin >> n;

	int max = 0;

	while (n--) {
		int a, b, c;
		int arr[7] = { 0, };
		std::cin >> a >> b >> c;
		arr[a]++;
		arr[b]++;
		arr[c]++;


		int prize = 0;
		for (int i = 1; i <= 6; i++) {
			if (arr[i] == 3) {
				prize = 10000 + i * 1000;
				break;
			}
			else if (arr[i] == 2) {
				prize = 1000 + i * 100;
				break;
			}
			
			if (arr[i]) {
				prize = i * 100;
			}
		}

		if (prize > max) {
			max = prize;
		}
	}

	std::cout << max;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}